package sh.astrid.minehutfriends;

import me.aroze.arozeutils.minecraft.FancyPlugin
import me.honkling.commando.CommandManager
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

        val commandManager = CommandManager(this)

        commandManager.registerCommands("sh.astrid.minehutfriends.commands")

        PlayerJoin()
    }

    override fun onDisable() {

    }
}