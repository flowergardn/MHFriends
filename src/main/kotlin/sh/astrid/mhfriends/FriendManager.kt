package sh.astrid.mhfriends

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.bukkit.Bukkit
import java.net.URL
import java.util.*

class FriendManager {
    private val friends = mutableMapOf<UUID, List<FriendsResponse.Friend>>()

    @Serializable
    data class FriendsResponse(
        @SerialName("friends")
        val friends: List<Friend>
    ) {
        @Serializable
        data class Friend(
            @SerialName("_id")
            val id: String,
            val uuid: String,
            val name: String,
            @SerialName("name_lower")
            val nameLower: String,
            val online: Boolean,
            val rank: String
        )
    }

    private fun addFriend(player: UUID, friend: FriendsResponse.Friend) {
        val playerFriends: List<FriendsResponse.Friend> = friends[player] ?: listOf()
        val updatedFriends = playerFriends + friend
        friends[player] = updatedFriends
    }

    fun getFriends(player: UUID): List<FriendsResponse.Friend>? {
       return friends[player]
    }

    fun fetchFriends(uuid: UUID) {
        friends[uuid] = listOf()

        val apiUrl = "https://api.minehut.com/network/player/${uuid}/friends"
        val json = URL(apiUrl).readText()

        val friendResponse: FriendsResponse = Json.decodeFromString(json)

        friendResponse.friends.forEach {
            val player = Bukkit.getOfflinePlayer(UUID.fromString(it.uuid))
            if(player.isOnline)
                addFriend(uuid, it)
        }
    }
}