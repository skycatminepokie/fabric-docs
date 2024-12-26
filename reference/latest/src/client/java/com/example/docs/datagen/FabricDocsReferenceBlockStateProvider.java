package com.example.docs.datagen;

import com.example.docs.block.ModBlocks;

import com.example.docs.block.custom.PrismarineLampBlock;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.BlockStateVariantMap;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

// :::datagen-block-states:provider
public class FabricDocsReferenceBlockStateProvider extends FabricModelProvider {

	public FabricDocsReferenceBlockStateProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		// :::datagen-block-states:provider
		// :::datagen-block-states:simple
		blockStateModelGenerator.blockStateCollector.accept(
				// singleton, no properties we care about for model selection and no variants
				BlockStateModelGenerator.createSingletonBlockState(
						// the block to generate the block state for
						ModBlocks.CONDENSED_DIRT,
						// we use the block id as the model id
						Registries.BLOCK.getId(ModBlocks.CONDENSED_DIRT).withPrefixedPath("block/")
				)
		);
		// :::datagen-block-states:simple
		// :::datagen-block-states:axis-rotated
		blockStateModelGenerator.blockStateCollector.accept(
				// create a supplier for the block
				VariantsBlockStateSupplier
						.create(
								ModBlocks.CONDENSED_OAK_LOG,
								// each variant in the "coordinate" call gets these Settings
								BlockStateVariant.create()
										.put(
												// the model to use
												VariantSettings.MODEL,
												Registries.BLOCK.getId(ModBlocks.CONDENSED_OAK_LOG).withPrefixedPath("/block")
										)
						)
						// coordinate takes a map of (all the properties and their values) -> (which model we want to use)
						.coordinate(
								BlockStateVariantMap.create(Properties.AXIS)
										.register(Direction.Axis.X, BlockStateVariant.create()
												.put(VariantSettings.X, VariantSettings.Rotation.R90) // When it's placed along the x-axis, we rotate the texture around the x-axis
												.put(VariantSettings.Y, VariantSettings.Rotation.R90)) // And then the y-axis
										.register(Direction.Axis.Y, BlockStateVariant.create()) // Default it's placed along the y-axis
										.register(Direction.Axis.Z, BlockStateVariant.create()
												.put(VariantSettings.X, VariantSettings.Rotation.R90)) // When it's placed along the z-axis, we rotate the texture around the x-axis
						)

		);
		// :::datagen-block-states:axis-rotated
		// :::datagen-block-states:boolean-state
		Identifier id = Registries.BLOCK.getId(ModBlocks.PRISMARINE_LAMP).withPrefixedPath("blocks/");
		blockStateModelGenerator.blockStateCollector.accept(
				VariantsBlockStateSupplier
						// create a supplier for the block
						.create(ModBlocks.PRISMARINE_LAMP)
						.coordinate(
								// the createBooleanModelMap helper method creates a map for a boolean property
								BlockStateModelGenerator.createBooleanModelMap(
										// the block property to use
										PrismarineLampBlock.ACTIVATED,
										// the model id to use when true
										id.withSuffixedPath("_on"),
										// the model id to use when false
										id
								)
						)
		);
		// :::datagen-block-states:boolean-state
		// :::datagen-block-states:provider
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {

	}
}
// :::datagen-block-states:provider