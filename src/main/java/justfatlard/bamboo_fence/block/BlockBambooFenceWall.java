package justfatlard.bamboo_fence.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.EntityContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;

public class BlockBambooFenceWall extends Block implements Waterloggable {
	private static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
	public static final BooleanProperty WATERLOGGED;

	protected static final VoxelShape Y_SHAPE = Block.createCuboidShape(7.0D, 0.0D, 0.0D, 10.0D, 9.0D, 16.0D);
	protected static final VoxelShape Z_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
	protected static final VoxelShape X_SHAPE = Block.createCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);

	public BlockBambooFenceWall(Settings block$Settings) {
		super(block$Settings);

		this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(WATERLOGGED, false)).with(FACING, Direction.NORTH)));
	}

	@Override
	public VoxelShape getOutlineShape(BlockState blockState, BlockView blockView, BlockPos blockPosition, EntityContext entityContext) {
		switch((Direction)blockState.get(FACING)) {
			case NORTH:
				return Z_SHAPE;
			case SOUTH:
				return Z_SHAPE;
			case WEST:
				return X_SHAPE;
			case EAST:
				return X_SHAPE;
			default:
				return X_SHAPE;
		}
	}

	@Override
	public VoxelShape getCollisionShape(BlockState blockState, BlockView blockView, BlockPos blockPosition, EntityContext entityContext) {
		return this.collidable ? blockState.getOutlineShape(blockView, blockPosition) : VoxelShapes.empty();
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext placementContext) {
		BlockPos blockPos = placementContext.getBlockPos();
		FluidState fluidState = placementContext.getWorld().getFluidState(blockPos);

		return (BlockState)((BlockState)this.getDefaultState().with(FACING, placementContext.getPlayerFacing().getOpposite())).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
	}

	public FluidState getFluidState(BlockState state) {
		return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
	}

	public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState neighborState, IWorld world, BlockPos pos, BlockPos neighborPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}

		return super.getStateForNeighborUpdate(state, facing, neighborState, world, pos, neighborPos);
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	static {
		WATERLOGGED = Properties.WATERLOGGED;
	}
}