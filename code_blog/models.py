from django.db import models
from django.contrib.auth.models import User
from ckeditor_uploader.fields import RichTextUploadingField
from common_func.models import ReadnumMethod
# Create your models here.

prefix = "code_"  # 设置前缀


class Category(models.Model):
    name = models.CharField(max_length=30)
    text = models.CharField(max_length=120, blank=True, null=True)

    def __str__(self):
        return self.name

    def get_absolute_url(self):
        from django.urls import reverse
        return reverse(prefix+'blog_category', args=(self.id,))


class Tag(models.Model):
    name = models.CharField(max_length=50)

    def __str__(self):
        return self.name


class CodeBlog(models.Model, ReadnumMethod):
    title = models.CharField(max_length=70, verbose_name="标题")
    body = RichTextUploadingField(verbose_name="正文")
    created_time = models.DateTimeField(auto_now_add=True, verbose_name="创建日期")
    modified_time = models.DateTimeField(auto_now=True, verbose_name="修改日期")
    category = models.ForeignKey(Category,on_delete=models.CASCADE, verbose_name="分类")
    tag = models.ManyToManyField(Tag, blank=True, verbose_name="标签")
    author = models.ForeignKey(User, on_delete=models.CASCADE, verbose_name="作者")
    keywords = models.CharField(max_length=100, blank=True, verbose_name="关键词")
    descriptison = models.CharField(max_length=200, blank=True, verbose_name="描述")

    def __str__(self):
        return '<%s>' % self.title  # 设置后台显示默认模型信息

    class Meta:
        verbose_name_plural = "文章"
        ordering = ['-created_time']

    def get_absolute_url(self):  # 获得自己文章的url
        from django.urls import reverse
        return reverse(prefix+'blog_article', args=(self.id,))

