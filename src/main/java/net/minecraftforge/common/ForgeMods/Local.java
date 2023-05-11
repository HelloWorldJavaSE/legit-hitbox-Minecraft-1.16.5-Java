package net.minecraftforge.common.ForgeMods;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class Local {
    public static double si = 1; // не читаемые Названия переменных, класса,пакета, дла скрытия чита.

    @SubscribeEvent
    public void forge(RenderPlayerEvent e) {
        Entity player = e.getEntity();
        if (player != Minecraft.getInstance().player) {
            player.setBoundingBox(new AxisAlignedBB(
                            player.getPosX() - si,
                            player.getBoundingBox().minY,
                            player.getPosZ() - si,
                            player.getPosX() + si,
                            player.getBoundingBox().maxY,
                            player.getPosZ() + si
                    )
            );
        }
    }

    @SubscribeEvent
    public void Keyboard(InputEvent.KeyInputEvent k) {
        int a = k.getKey();
        if (a == 260) {
            si = 0.3;
        }
        if (a == 66) si = si + 0.05;
        if (a == 78) si = si - 0.05;
    }
}
