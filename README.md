Piscary is the fishing element of the Harvest Festival Collection. It adds a bunch of new fish to catch in different biomes as well as entity versions for them all! Also included are the hatchery where you can duplicate your fish and the fish trap which will catch fish for you, although it must be seeded with bait!

More information about Piscary and downloads can be found on //TODO

If you have any questions, feel free to join the [Harvest Festival Discord](https://discord.gg/MRZAyze)

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