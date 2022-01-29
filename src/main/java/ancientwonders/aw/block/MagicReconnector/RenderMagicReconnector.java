package ancientwonders.aw.block.MagicReconnector;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class RenderMagicReconnector extends TileEntityRenderer<TileMagicReconnector> {
    public RenderMagicReconnector(TileEntityRendererDispatcher render){
        super(render);
    }

    @Override
    public void render(TileMagicReconnector te, float v, MatrixStack matrix, IRenderTypeBuffer render, int i, int i1) {
        if(!te.isRemoved() && te.getWand() != null && !te.getWand().isEmpty()){
            matrix.push();
            matrix.scale(1, 1, 1);
            matrix.translate(.5, 1.5, .5);
            Minecraft.getInstance().getItemRenderer().renderItem(te.getWand(), ItemCameraTransforms.TransformType.NONE, 200, OverlayTexture.NO_OVERLAY,  matrix, render);
            matrix.pop();
        }
    }
}
