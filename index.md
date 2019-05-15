# Welcome to my blog

I'm glad you are here. I plan to talk about ...
This is my first blog which is for learning how to host a blog service on Github

<ul>
  {% for post in site.posts %}
    <li>
      <a href="{{ post.url }}">{{ post.title }}</a>
    </li>
  {% endfor %}
</ul>