package org.rsmod.api.repo.world

import jakarta.inject.Inject
import org.rsmod.api.registry.zone.ZoneUpdateMap
import org.rsmod.game.entity.Npc
import org.rsmod.game.entity.PathingEntity
import org.rsmod.game.entity.Player
import org.rsmod.game.loc.BoundLocInfo
import org.rsmod.game.loc.LocInfo
import org.rsmod.game.proj.ProjAnim
import org.rsmod.game.type.proj.ProjAnimType
import org.rsmod.game.type.proj.ProjAnimTypeList
import org.rsmod.game.type.seq.SeqType
import org.rsmod.game.type.spot.SpotanimType
import org.rsmod.game.type.synth.SynthType
import org.rsmod.map.CoordGrid

public class WorldRepository
@Inject
constructor(private val zoneUpdates: ZoneUpdateMap, private val projAnims: ProjAnimTypeList) {
    public fun locAnim(loc: LocInfo, seq: SeqType) {
        zoneUpdates.locAnim(loc, seq.id)
    }

    public fun locAnim(loc: BoundLocInfo, seq: SeqType) {
        locAnim(LocInfo(loc.layer, loc.coords, loc.entity), seq)
    }

    public fun soundArea(
        source: CoordGrid,
        synth: SynthType,
        delay: Int = 0,
        loops: Int = 1,
        radius: Int = 5,
        size: Int = 0,
    ) {
        zoneUpdates.soundArea(source, synth.id, delay, loops, radius, size)
    }

    public fun soundArea(
        source: PathingEntity,
        synth: SynthType,
        delay: Int = 0,
        loops: Int = 1,
        radius: Int = 5,
    ) {
        soundArea(source.coords, synth, delay, loops, radius, source.size)
    }

    public fun spotanimMap(
        spotanim: SpotanimType,
        coord: CoordGrid,
        height: Int = 0,
        delay: Int = 0,
    ) {
        zoneUpdates.mapAnim(spotanim.id, coord, height, delay)
    }

    public fun projAnim(projAnim: ProjAnim) {
        zoneUpdates.mapProjAnim(projAnim)
    }

    public fun projAnim(
        source: Player,
        target: Npc,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim =
            ProjAnim.fromBoundsToNpc(source.bounds(), target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnimSourced(
        source: Player,
        target: Npc,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim = ProjAnim.fromPlayerToNpc(source, target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnim(
        source: Player,
        target: Player,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim =
            ProjAnim.fromBoundsToPlayer(source.bounds(), target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnimSourced(
        source: Player,
        target: Player,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim = ProjAnim.fromPlayerToPlayer(source, target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnim(
        source: Player,
        target: CoordGrid,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim =
            ProjAnim.fromBoundsToCoord(source.bounds(), target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnimSourced(
        source: Player,
        target: CoordGrid,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim = ProjAnim.fromPlayerToCoord(source, target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnim(
        source: Npc,
        target: Npc,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim =
            ProjAnim.fromBoundsToNpc(source.bounds(), target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnimSourced(
        source: Npc,
        target: Npc,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim = ProjAnim.fromNpcToNpc(source, target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnim(
        source: Npc,
        target: Player,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim =
            ProjAnim.fromBoundsToPlayer(source.bounds(), target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnimSourced(
        source: Npc,
        target: Player,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim = ProjAnim.fromNpcToPlayer(source, target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnim(
        source: Npc,
        target: CoordGrid,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim =
            ProjAnim.fromBoundsToCoord(source.bounds(), target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }

    public fun projAnimSourced(
        source: Npc,
        target: CoordGrid,
        spotanim: SpotanimType,
        type: ProjAnimType,
    ): ProjAnim {
        val projAnim = ProjAnim.fromNpcToCoord(source, target, spotanim.id, projAnims[type])
        projAnim(projAnim)
        return projAnim
    }
}
