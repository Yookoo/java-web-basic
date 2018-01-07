# Shiro认证过程

1. 获取当前的Subject（用户）;
2. 判断当前用户是否已经认证。
3. 若没有认证将当前的Subject的用户名和密码封装为UsernamePasswordToken对象；
4. 执行认证Subject.login(UsernamePasswordToken);
5. 自定义Realm方法从数据库中获取对应的记录，返回给shiro;
6. shiro 完成密码的匹配。
