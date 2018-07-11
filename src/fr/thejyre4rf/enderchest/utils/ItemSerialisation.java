package fr.thejyre4rf.enderchest.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.google.common.io.ByteStreams;
import com.google.common.io.OutputSupplier;

import fr.thejyre4rf.enderchest.utils.NbtFactory.NbtCompound;
import fr.thejyre4rf.enderchest.utils.NbtFactory.NbtList;
import fr.thejyre4rf.enderchest.utils.NbtFactory.StreamOptions;


@SuppressWarnings("deprecation")
public class ItemSerialisation {
    


    public static String serializeInventory(Inventory source) throws IOException {

        NbtCompound container = NbtFactory.createCompound();

        NbtList items = NbtFactory.createList();

        

        for (int i = 0; i < source.getSize(); i++) {

            ItemStack stack = source.getItem(i);

            NbtCompound nbt = NbtFactory.createCompound();



            // Manually save the data in an item stack

            if (stack != null && stack.getType() != Material.AIR) {

                NbtCompound tag = NbtFactory.fromItemTag(stack);

                                

                nbt.put("id", (short)stack.getTypeId());

                nbt.put("data", (short)stack.getDurability());

                nbt.put("count", (byte)stack.getAmount());

                

                if (tag != null) {

                    nbt.put("tag", tag);

                }

            } else {

                nbt.put("id", (short)0); // AIR

            }

            items.add(nbt);

        }



        // Save items

        container.put("items", items);

    

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        NbtFactory.saveStream(container, 

            getSupplier(output), StreamOptions.GZIP_COMPRESSION);

        return Base64Coder.encodeLines(output.toByteArray());

    }

    

    public static void deserializeInventory(String data, Inventory destination) throws IOException {

		NbtCompound container = NbtFactory.fromStream(

            ByteStreams.newInputStreamSupplier(Base64Coder.decodeLines(data)),

            StreamOptions.GZIP_COMPRESSION

        );

        int index = 0;

        

        // Each entry should be an NbtCompound

        for (Object element : container.getList("items", true)) {

            NbtCompound nbt = (NbtCompound) element;
            

            ItemStack stack = new ItemStack(

                nbt.getShort("id", (short)0), 

                nbt.getByte("count", (byte)0), 

                nbt.getShort("data", (short)0));

            

            if (nbt.containsKey("tag")) {

                // Necessary to be able to manipulate NBT tags

                stack = NbtFactory.getCraftItemStack(stack); 

                NbtFactory.setItemTag(stack, nbt.getMap("tag", false));

            }

            destination.setItem(index++, stack);

        }

    }

    

	private static OutputSupplier<OutputStream> getSupplier(final ByteArrayOutputStream output) {

        return new OutputSupplier<OutputStream>() {

            @Override

            public OutputStream getOutput() throws IOException {

                return output;

            }

        };

    }
    
}