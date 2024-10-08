package com.example.louemonchar.presentation.camera

import android.content.ContentValues
import android.content.Context
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.Locale


class CameraPresentateur(modele: CameraModele, private val vue: CameraInterface.Vue,  private val context: Context):CameraInterface.Presentateur {

    val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"

    override fun prendrePhoto(imageCapture: ImageCapture) {
        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
            .format(System.currentTimeMillis())
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
            }
        }
        val outputOptions = ImageCapture.OutputFileOptions
            .Builder(context.contentResolver,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues)
            .build()
        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(context),
            object : ImageCapture.OnImageSavedCallback {
                override fun onError(exc: ImageCaptureException) {
                    Log.e(ContentValues.TAG, "CAPTURE PHOTO N'A PAS FONCTIONNÉ", exc)
                }
                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    val msg = "CAPTURE PHOTO AVEC SUCCES"
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                    Log.d(ContentValues.TAG, msg)
                }
            }
        )
    }

    override fun retourVersEnregistrement() {
        vue.retour()
    }


}
