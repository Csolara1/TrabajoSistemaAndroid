package us.ldts.ktldts1rv

import com.google.gson.annotations.SerializedName

data class ListItem(
    @SerializedName("alumnoNombre")
    val alumnos: String,

    @SerializedName("examenDescripcion")
    val examenes: String,

    @SerializedName("notaAlumno")
    val notas: String,

    @SerializedName("materiaNombre")
    val materias: String
)
