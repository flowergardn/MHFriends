package sh.astrid.mhfriends.events

import me.aroze.arozeutils.minecraft.generic.delay
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import sh.astrid.mhfriends.MHFriends

class PlayerJoin : org.bukkit.event.Listener {
    init {
        MHFriends.getInstance().server.pluginManager.registerEvents(this, MHFriends.getInstance())
    }

    private val friendManager = MHFriends.getFriendManager()

    private fun fetch() {
        Bukkit.getOnlinePlayers().forEach {
            friendManager.fetchFriends(it.uniqueId)
        }
    }

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        fetch()
    }

    @EventHandler
    fun onLeave(event: PlayerQuitEvent) {
        delay({ fetch() }, 30)
    }
}