@file:Command(
    "online",
    description = "View your online friends"
)

package sh.astrid.minehutfriends.commands

import me.aroze.arozeutils.minecraft.generic.coloured
import me.honkling.commando.lib.Command
import org.bukkit.entity.Player
import sh.astrid.minehutfriends.MinehutFriends

fun online(executor: Player) {
    val friendManager = MinehutFriends.getFriendManager()
    val allFriends = friendManager.getFriends(executor.uniqueId) ?: return

    executor.sendMessage("&pYou currently have &s${allFriends.size}&p friends online right now!".coloured())
}