<img src="https://harvestfestivalwiki.com/images/a/a1/Piscary-Logo.svg" width="70%">

[![Discord](https://img.shields.io/discord/227497118498029569?style=plastic&colorB=7289DA&logo=discord&logoColor=white)](http://discord.gg/0vVjLvWg5kyQwnHG) &nbsp; ![GitHub](https://img.shields.io/github/license/Harvest-Festival/Piscary?color=%23990000&style=plastic) &nbsp; ![Jenkins](https://img.shields.io/jenkins/build?jobUrl=https%3A%2F%2Fjenkins.joshiejack.uk%2Fjob%2FPiscary%2F&style=plastic) &nbsp; ![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fmaven.joshiejack.uk%2Fuk%2Fjoshiejack%2Fpiscary%2FPiscary%2Fmaven-metadata.xml&style=plastic) &nbsp; [![Curseforge](http://cf.way2muchnoise.eu/full_piscary_downloads.svg)](https://www.curseforge.com/minecraft/mc-mods/piscary)

Piscary is the fishing element of the Harvest Festival Collection. It adds a bunch of new fish to catch in different biomes as well as entity versions for them all! Also included are the hatchery where you can duplicate your fish and the fish trap which will catch fish for you, although it must be seeded with bait!

More information about Piscary can be found at https://harvestfestivalwiki.com/Piscary

Adding Piscary to your buildscript
---
Add to your build.gradle:
```gradle
repositories {
  maven {
    url 'https://maven.joshiejack.uk/'
  }
}

dependencies {
    compile fg.deobf("uk.joshiejack.penguinlib:Penguin-Lib:${minecraft_version}-${penguinlib_version}")
    compile fg.deobf("uk.joshiejack.piscary:Piscary:${minecraft_version}-${piscary_version}")
}
```

`${$penguinlib_version}` can be found [here](https://maven.joshiejack.uk/uk/joshiejack/penguinlib/Penguin-Lib/)
`${piscary_version}` can be found [here](https://maven.joshiejack.uk/uk/joshiejack/piscary/Piscary/)