## Cognitio


Cognitio is a Java Wrapper for the Tatsumaki API.


Added Features:
- Leaderboard Grabbing
- User info

In Development:
- Adding/removing/setting points
- Adding/removing/setting score

To grab leaderboards you need an `IGuildHandler`, to do this it's as easy as:
```java
IGuildHandler handler = new GuildHandler(YOUR_API_KEY_HERE);
```

To grab a user's info you need an`IUserHandler`
```java
IUserHandler handler = new UserHandler(YOUR_API_KEY_HERE);
```

Contact xaanit#1703 on Discord with any problems.

### Using Cognitio

Maven (Add the following to your pom.xml, no elipses):
```xml
...
	<repositories>
        ...
		<repository>
			<id>jitpack.io</id>
			<url>https://jitpack.io</url>
		</repository>
	...
	</repositories>
...
```

```xml

```