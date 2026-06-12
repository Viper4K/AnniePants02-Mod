package net.mcreator.anniepantsmod.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class AnnieCustomPaintingRightclickedOnBlockProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z,
                               BlockState blockstate, Direction direction, Entity entity, ItemStack itemstack) {
		
		if (direction == null || entity == null)
            return;

        if (direction.getAxis() == Direction.Axis.Y)
            return;

        if (!(world instanceof Level level))
            return;

        if (world.isClientSide())
            return;

        if (!(entity instanceof Player player))
            return;

        BlockPos clickedPos = BlockPos.containing(x, y, z);
        BlockPos hangPos = clickedPos.relative(direction);

        TagKey<PaintingVariant> customTag = TagKey.create(
                Registries.PAINTING_VARIANT,
                ResourceLocation.fromNamespaceAndPath("anniepantsmod", "placeable")
        );

        List<Holder<PaintingVariant>> candidates = new ArrayList<>();
        level.registryAccess()
                .registryOrThrow(Registries.PAINTING_VARIANT)
                .holders()
                .filter(h -> h.is(customTag))
                .forEach(candidates::add);

        if (candidates.isEmpty())
            return;

        List<Holder<PaintingVariant>> shuffled = new ArrayList<>(candidates);
        Collections.shuffle(shuffled, new Random(level.getRandom().nextLong()));

        Optional<Painting> paintingToPlace = Optional.empty();

        for (Holder<PaintingVariant> variant : shuffled) {
            Painting painting = new Painting(level, hangPos, direction, variant);
            if (painting.survives()) {
                paintingToPlace = Optional.of(painting);
                break;
            }
        }

        paintingToPlace.ifPresent(painting -> {
            painting.playPlacementSound();
            level.addFreshEntity(painting);

            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
        });
    }
}