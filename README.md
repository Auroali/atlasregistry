# Adding to a project
You can use jitpack to add the mod as a dependency
```groovy
repositories {
    maven {
        name = 'Jitpack'
        url = 'https://jitpack.io'
    }        
}
```
Then you just need to add it to the dependencies
```groovy
dependencies {
    modImplementation "com.github.auroali:atlasregistry:<version>"
    include "com.github.auroali:atlasregistry:<version>"
}
```
At the moment there are no releases, so the version will have to be a short commit hash

# Usage
To start, you must create a `SpriteAtlasReference` using a `SpriteAtlasReferenceBuilder`
```java
public static final SpriteAtlasReference EXAMPLE = SpriteAtlasReferenceBuilder.create(new Identifier("modid", "example"))
        .mipLevel(0) // optional, sets the mip level of the atlas reference. Defaults to 0 when unspecified
        .reloadCallback((id, atlas) -> { /* callback code */ }) // optional, registers a callback to run each time the atlas is loaded
        .build();
```
You can then register it in the client initializer
```java
void onInitializeClient() {
    /* other code */
    AtlasRegistry.register(EXAMPLE);
}
```
Once registered, it will automatically be loaded and populated with sprites whenever the game reloads resources

For the game to know where to load textures for the atlas from, you must create an atlas json file in `assets/<modid>/atlases/<atlas id>.json`.
```json5
{
  "sources": [
    {
      "type": "directory",
      "source": "example",
      "prefix": "example/" // prefix for the loaded sprite (ie textures/<modid>/example/test.png will be loaded as <modid>:example/test)
    },
    {
      "type": "single",
      "resource": "example2/single",
      "sprite": "example/single" // sprite name, if omitted defaults to the value of resource
    }
  ]
}
```
The above will load textures from `textures/example/`. For more information, see https://minecraft.wiki/w/Atlas

# Vanilla Atlases
There are SpriteAtlasReferences defined for some vanilla atlases in `VanillaAtlasReferences`. These can be used to either directly access the vanilla atlases, or as a utility for creating things like SpriteIdentifiers