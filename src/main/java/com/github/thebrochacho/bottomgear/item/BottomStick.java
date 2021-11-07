package com.github.thebrochacho.bottomgear.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.github.thebrochacho.bottomgear.BottomGear.MODID;

public class BottomStick extends Item {

    public BottomStick() {
        this.setUnlocalizedName("bottom_stick");
        this.setNoRepair();
        this.setMaxDamage(1);
        setTextureName(MODID + ":bottomStick");
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        printAllGearNames(getAllGearNames());

        return p_77659_1_;
    }

    public Map<String, ArrayList<String>> getAllGearNames() {
        Map<String, ArrayList<String>> unlocalizedGearNames = new HashMap<>();
        unlocalizedGearNames.put("helmets", new ArrayList<>());
        unlocalizedGearNames.put("chestplates", new ArrayList<>());
        unlocalizedGearNames.put("leggings", new ArrayList<>());
        unlocalizedGearNames.put("boots", new ArrayList<>());
        unlocalizedGearNames.put("weapons", new ArrayList<>());

        for (Item item : (Iterable<Item>) Item.itemRegistry) {
            if (item instanceof ItemArmor) {
                switch (((ItemArmor) item).armorType) {
                    case 0:
                        unlocalizedGearNames.get("helmets").add(item.getUnlocalizedName());
                        break;
                    case 1:
                        unlocalizedGearNames.get("chestplates").add(item.getUnlocalizedName());
                        break;
                    case 2:
                        unlocalizedGearNames.get("leggings").add(item.getUnlocalizedName());
                        break;
                    case 3:
                        unlocalizedGearNames.get("boots").add(item.getUnlocalizedName());
                        break;
                }
            }
            else if (item instanceof ItemSword || item instanceof ItemBow) {
                unlocalizedGearNames.get("weapons").add(item.getUnlocalizedName());
            }
        }

        return unlocalizedGearNames;
    }

    public void printAllGearNames(Map<String, ArrayList<String>> unlocalizedGearNames) {
        for (String key : unlocalizedGearNames.keySet()) {
            System.out.println("Gear Type: " + key);
            for (String unlocalizedName : unlocalizedGearNames.get(key)) {
                System.out.println(unlocalizedName);
            }
            System.out.println();
        }
    }
}
