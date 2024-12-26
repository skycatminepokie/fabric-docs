---
title: Block State Generation
description: A guide to setting up block state generation with datagen.
authors:
  - skycatminepokie
  - cputnam-a11y
---

# Block State Generation {#block-state-generation}

::: info PREQUISITES
Make sure you've completed the [datagen setup](./setup) process first.
:::

## Setup {#setup}

First, we'll need our provider. Make a class that `extends FabricModelProvider`. Our generation will happen inside the `generateBlockStateModels` method of our provider.

@[code lang=java transcludeWith=:::datagen-block-states:provider](@/reference/latest/src/client/java/com/example/docs/datagen/FabricDocsReferenceBlockStateProvider.java)

And add it to your pack in your generator:

@[code lang=java transcludeWith=:::datagen-block-states:generator](@/reference/latest/src/client/java/com/example/docs/datagen/FabricDocsReferenceBlockStateGenerator.java)

## Simple Block State {#simple-block-state}

Let's start with a simple block state - a singleton. This is for a block that has just one state.

@[code lang=java transcludeWith=:::datagen-block-states:simple](@/reference/latest/src/client/java/com/example/docs/datagen/FabricDocsReferenceBlockStateProvider.java)

::: tip
Take a look around for what methods are available - they can make your life easier. For example, we can do the same simple state with just one line:

```java
blockStateModelGenerator.registerSimpleState(ModBlocks.CONDENSED_DIRT);
```
:::

## Axis Rotated Block State {#axis-rotated-block-state}

Next we'll take a look at a block with varients depending on how the block is oriented. %%TODO: get confirmation on the comments%%

@[code lang=java transcludeWith=:::datagen-block-states:axis-rotated](@/reference/latest/src/client/java/com/example/docs/datagen/FabricDocsReferenceBlockStateProvider.java)

::: tip
This can also take advantage of helper methods!
```java
blockStateModelGenerator.registerAxisRotated(ModBlocks.CONDENSED_OAK_LOG, Registries.BLOCK.getId(ModBlocks.CONDENSED_OAK_LOG).withPrefixedPath("/block"));
```
:::

## Boolean Block State {#boolean-block-state}

Now, let's generate a block state for a block that has a boolean property. This block was made in the [Block States](../blocks/blockstates) tutorial.

@[code lang=java transcludeWith=:::datagen-block-states:boolean-state](@/reference/latest/src/client/java/com/example/docs/datagen/FabricDocsReferenceBlockStateProvider.java)
