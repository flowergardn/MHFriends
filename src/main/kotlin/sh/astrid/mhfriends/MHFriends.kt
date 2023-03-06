package sh.astrid.mhfriends

import ch.njol.skript.Skript
import me.aroze.arozeutils.minecraft.FancyPlugin
import me.honkling.commando.CommandManager
import org.bukkit.Bukkit
import sh.astrid.mhfriends.events.*

val friends = FriendManager()

class MHFriends : FancyPlugin() {
    companion object {
        fun getInstance() : MHFriends { return getPlugin(MHFriends::class.java) }
        fun getFriendManager(): FriendManager {
            return friends
        }
    }

    override fun onEnable() {
        super.onEnable()

        val basePkg = "sh.astrid.mhfriends"

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