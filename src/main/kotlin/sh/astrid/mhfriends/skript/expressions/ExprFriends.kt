package sh.astrid.mhfriends.skript.expressions

import ch.njol.skript.Skript
import ch.njol.skript.lang.Expression
import ch.njol.skript.lang.ExpressionType
import ch.njol.skript.lang.SkriptParser
import ch.njol.skript.lang.util.SimpleExpression
import ch.njol.util.Kleenean
import org.bukkit.entity.Player
import org.bukkit.event.Event
import sh.astrid.mhfriends.FriendManager.FriendsResponse.Friend
import sh.astrid.mhfriends.MHFriends

class ExprFriends : SimpleExpression<Friend>() {
    companion object {
        init {
            Skript.registerExpression(
                ExprFriends::class.java,
                Friend::class.java,
                ExpressionType.SIMPLE,
                "friends of %player%"
            )
        }
    }

    lateinit var playerExpr: Expression<Player>

    override fun init(
        exprs: Array<out Expression<*>>?,
        matchedPattern: Int,
        isDelayed: Kleenean?,
        parseResult: SkriptParser.ParseResult?
    ): Boolean {
        playerExpr = exprs!![0] as Expression<Player>
        return true
    }

    override fun get(e: Event): Array<Friend> {
        val friendManager = MHFriends.getFriendManager()
        val player = playerExpr.getSingle(e)!!.uniqueId
        val friends = friendManager.getFriends(player)

        if (friends == null)
            friendManager.fetchFriends(player)

        return (friends ?: friendManager.getFriends(player))!!.toTypedArray()
    }

    override fun getReturnType(): Class<Friend> {
        return Friend::class.java
    }

    override fun isSingle(): Boolean {
        return false
    }

    override fun toString(e: Event?, debug: Boolean): String {
        return "friends of ${playerExpr.getSingle(e)}"
    }
}