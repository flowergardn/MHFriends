@file:Command(
    "online",
    description = "View your online friends"
)

package sh.astrid.mhfriends.commands

import me.aroze.arozeutils.minecraft.generic.coloured
import me.honkling.commando.lib.Command
import org.bukkit.entity.Player
import sh.astrid.mhfriends.MHFriends

fun online(executor: Player) {
    val friendManager = MHFriends.getFriendManager()
    val allFriends = friendManager.getFriends(executor.uniqueId) ?: return

    executor.sendMessage("&pYou currently have &s${allFriends.size}&p friends online right now!".coloured())
}