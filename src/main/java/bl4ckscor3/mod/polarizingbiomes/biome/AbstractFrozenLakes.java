package bl4ckscor3.mod.polarizingbiomes.biome;

import bl4ckscor3.mod.polarizingbiomes.PolarizingBiomeFeatures;
import bl4ckscor3.mod.snowundertrees.SnowUnderTrees;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

public abstract class AbstractFrozenLakes extends Biome
{
	public AbstractFrozenLakes(Biome.Builder biomeBuilder)
	{
		super(biomeBuilder);

		//addStructure
		func_226711_a_(Feature.VILLAGE.func_225566_b_(new VillageConfig("village/snowy/town_centers", 6)));
		func_226711_a_(Feature.IGLOO.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
		func_226711_a_(Feature.MINESHAFT.func_225566_b_(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
		func_226711_a_(Feature.STRONGHOLD.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
		func_226711_a_(Feature.PILLAGER_OUTPOST.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));

		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addStructures(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addStoneVariants(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		addLakes();
		addLakes();
		PolarizingBiomeFeatures.addSpruceTrees(this, 1, 0.1F, 0);
		//oak trees
		addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.func_225566_b_(DefaultBiomeFeatures.field_226739_a_)
				.func_227228_a_(Placement.COUNT_EXTRA_HEIGHTMAP.func_227446_a_(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addGrass(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		SnowUnderTrees.addSnowUnderTrees(this);

		addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.RABBIT, 10, 2, 3));
		addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.POLAR_BEAR, 1, 1, 2));
		addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 20, 4, 4));
		addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.STRAY, 80, 4, 4));
	}

	@Override
	public int func_225528_a_(double d1, double d2) //getGrassColor
	{
		return 0xFEFEFE;
	}

	@Override
	public int func_225527_a_() //getFoliageColor
	{
		return 0xFEFEFE;
	}

	protected abstract void addLakes();
}
