package sh.astrid.minehutfriends;

import ch.njol.skript.Skript
import me.aroze.arozeutils.minecraft.FancyPlugin
import me.honkling.commando.CommandManager
import org.bukkit.Bukkit
import sh.astrid.minehutfriends.events.*

val friends = FriendManager()

class MinehutFriends : FancyPlugin() {
    companion object {
        fun getInstance() : MinehutFriends { return getPlugin(MinehutFriends::class.java) }
        fun getFriendManager(): FriendManager {
            return friends
        }
    }

    override fun onEnable() {
        super.onEnable()

        val basePkg = "sh.astrid.minehutfriends"

        val commandManager = CommandManager(this)
        val pluginManager = Bukkit.getPluginManager()

        commandManager.registerCommands("$basePkg.commands")

        PlayerJoin()

        if (!pluginManager.isPluginEnabled("Skript")) return

        logger.info("Detected Skript! Registering syntax.")

        val addon = Skript.registerAddon(this)
        addon.loadClasses(basePkg, "skript")
    }

    override fun onDisable() {

    }
}