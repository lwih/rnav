package fr.gouv.dgampa.rapportnav.domain.entities.monitorenv.mission

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.locationtech.jts.geom.Geometry
import java.time.ZonedDateTime
import java.util.*

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "actionType",
    visible = true,
)
@JsonSubTypes(
    JsonSubTypes.Type(EnvActionControlEntity::class, name = "CONTROL"),
    JsonSubTypes.Type(EnvActionSurveillanceEntity::class, name = "SURVEILLANCE"),
    JsonSubTypes.Type(EnvActionNoteEntity::class, name = "NOTE"),
)
abstract class EnvActionEntity(
    open val id: UUID,
    open val actionType: ActionTypeEnum,
    open val actionStartDateTimeUtc: ZonedDateTime? = null,
    open val actionEndDateTimeUtc: ZonedDateTime? = null,
    open val department: String? = null,
    open val facade: String? = null,
    open val geom: Geometry? = null
)
