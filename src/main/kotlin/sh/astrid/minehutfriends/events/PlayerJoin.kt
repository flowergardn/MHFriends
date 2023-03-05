package sh.astrid.minehutfriends.events

import me.aroze.arozeutils.minecraft.generic.delay
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import sh.astrid.minehutfriends.MinehutFriends

class PlayerJoin : org.bukkit.event.Listener {
    init {
        MinehutFriends.getInstance().server.pluginManager.registerEvents(this, MinehutFriends.getInstance())
    }

    private val friendManager = MinehutFriends.getFriendManager()

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        Bukkit.getOnlinePlayers().forEach {
            friendManager.fetchFriends(it.uniqueId)
        }
    }

    @EventHandler
    fun onLeave(event: PlayerQuitEvent) {
        delay({
            Bukkit.getOnlinePlayers().forEach {
                friendManager.fetchFriends(it.uniqueId)
            }
        }, 30)
    }
}