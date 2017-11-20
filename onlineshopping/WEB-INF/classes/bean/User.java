package bean;
public class User
{
String name,password;
public void setName(String name)
{
	this.name=name;
}

public void setPassword(String pass)
{
	this.password=pass;
}

public String getName()
{
	return this.name;
}

public String getPassword()
{
	return this.password;
}
}