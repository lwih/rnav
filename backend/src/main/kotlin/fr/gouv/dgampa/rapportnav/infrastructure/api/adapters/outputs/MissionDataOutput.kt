package fr.gouv.dgampa.rapportnav.infrastructure.api.adapters.outputs

import fr.gouv.dgampa.rapportnav.domain.entities.monitorenv.controlResources.ControlUnitEntity
import fr.gouv.dgampa.rapportnav.domain.entities.monitorenv.mission.EnvActionEntity
import fr.gouv.dgampa.rapportnav.domain.entities.monitorenv.mission.MissionEntity
import fr.gouv.dgampa.rapportnav.domain.entities.monitorenv.mission.MissionSourceEnum
import fr.gouv.dgampa.rapportnav.domain.entities.monitorenv.mission.MissionTypeEnum
import org.locationtech.jts.geom.MultiPolygon
import java.time.ZonedDateTime

data class MissionDataOutput(
    val id: Int,
    val missionTypes: List<MissionTypeEnum>,
    val controlUnits: List<ControlUnitEntity>? = listOf(),
    val openBy: String? = null,
    val closedBy: String? = null,
    val observationsCacem: String? = null,
    val observationsCnsp: String? = null,
    val facade: String? = null,
    val geom: MultiPolygon? = null,
    val startDateTimeUtc: ZonedDateTime,
    val endDateTimeUtc: ZonedDateTime? = null,
    val envActions: List<EnvActionEntity>? = null,
    val missionSource: MissionSourceEnum,
    val isClosed: Boolean,
    val hasMissionOrder: Boolean,
    val isUnderJdp: Boolean,
) {
    companion object {
        fun fromMission(mission: MissionEntity): MissionDataOutput {
            requireNotNull(mission.id) {
                "a mission must have an id"
            }

            return MissionDataOutput(
                id = mission.id,
                missionTypes = mission.missionTypes,
                controlUnits = mission.controlUnits,
                openBy = mission.openBy,
                closedBy = mission.closedBy,
                observationsCacem = mission.observationsCacem,
                observationsCnsp = mission.observationsCnsp,
                facade = mission.facade,
                geom = mission.geom,
                startDateTimeUtc = mission.startDateTimeUtc,
                endDateTimeUtc = mission.endDateTimeUtc,
                envActions = mission.envActions,
                missionSource = mission.missionSource,
                isClosed = mission.isClosed,
                hasMissionOrder = mission.hasMissionOrder,
                isUnderJdp = mission.isUnderJdp,
            )
        }
    }
}
