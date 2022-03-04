package com.adobe.phonegap.push

import android.annotation.SuppressLint
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService

/**
 * Push InstanceID Listener Service
 */
@Suppress("HardCodedStringLiteral")
@SuppressLint("LongLogTag", "LogConditional")
class PushInstanceIDListenerService : FirebaseMessagingService() {
  companion object {
    private const val TAG: String = "${PushPlugin.PREFIX_TAG} (PushInstanceIDListenerService)"
  }

  /**
   * Called when a new token is generated, after app install or token changes.
   *
   * @param token
   */
  override fun onNewToken(token: String) {
    super.onNewToken(token)
    FirebaseMessaging.getInstance().token.addOnSuccessListener { result ->
        if(result != null) {
            val refreshedToken : String = result
            Log.d(TAG, "Refreshed token: $refreshedToken")
            // DO your thing with your firebase token

            // TODO: Implement this method to send any registration to your app's servers.
            //sendRegistrationToServer(refreshedToken);
        }
    }
  }
}
