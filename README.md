
# MHFriends

Skript addon to provide online Minehut friends.


## API Reference

#### Grab players friends

Skript:
```
  friends of %player%
```
Kotlin:
```kt
import sh.astrid.mhfriends.MHFriends
// ...
val friendManager = MHFriends.getFriendManager()
val friends = friendManager.getFriends(player)
```

### Setting up API for Kotlin / Java
MHFriends is accessible via [Jitpack](https://jitpack.io). You can use it in your plugin by adding the Jitpack repository:

<details>
    <summary>Maven</summary>

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
</details>

After adding the repository, you can include MHFriends with the following:

<details>
    <summary>Maven</summary>

```xml
<dependency>
    <groupId>sh.astrid.mhfriends</groupId>
    <artifactId>MHFriends</artifactId>
    <version>1.0.0</version>
</dependency>
```
</details>

## License

[MIT](https://choosealicense.com/licenses/mit/)

