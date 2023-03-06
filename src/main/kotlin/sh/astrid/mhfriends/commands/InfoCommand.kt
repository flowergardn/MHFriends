@file:Command(
    "mhinfo",
    description = "View MHFriends information"
)

package sh.astrid.mhfriends.commands

import me.aroze.arozeutils.minecraft.generic.coloured
import me.honkling.commando.lib.Command
import org.bukkit.entity.Player
import sh.astrid.mhfriends.MHFriends

fun mhinfo(executor: Player) {
    val info = MHFriends.getInstance().description

    executor.sendMessage("&s${info.name}&p | version &s${info.version}".coloured())
    executor.sendMessage("An API to manage online Minehut friends.".coloured())
}