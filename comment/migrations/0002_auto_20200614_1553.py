# Generated by Django 3.0.5 on 2020-06-14 07:53

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('comment', '0001_initial'),
    ]

    operations = [
        migrations.AlterModelOptions(
            name='comment',
            options={'ordering': ['-created_time'], 'verbose_name_plural': '评论'},
        ),
    ]
