package com.example.mytestapp.phoneauth.presentation

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mytestapp.navigation.Screen
import com.example.mytestapp.ui.theme.greenColor
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

@Composable
fun PhoneAuthUI(context: Context, navController: NavController) {


    val phoneNumber = remember {
        mutableStateOf("")
    }

    val otp = remember {
        mutableStateOf("")
    }

    val verificationID = remember {
        mutableStateOf("")
    }

    val message = remember {
        mutableStateOf("")
    }


    var mAuth: FirebaseAuth = FirebaseAuth.getInstance();
    lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    Column(
        // adding modifier for our column
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on below line creating text field for phone number.
        TextField(
            // on below line we are specifying
            // value for our course name text field.
            value = phoneNumber.value,
            // on below line specifying key board type as number.
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            // on below line we are adding on
            // value change for text field.
            onValueChange = { phoneNumber.value = it },

            // on below line we are adding place holder
            // as text as "Enter your course name"
            placeholder = { Text(text = "Enter your phone number") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        // on below line adding spacer.
        Spacer(modifier = Modifier.height(10.dp))

        // on below line creating button to send verification code.
        Button(
            onClick = {
                // on below line we are validating user inputs
                if (TextUtils.isEmpty(phoneNumber.value.toString())) {
                    Toast.makeText(context, "Please enter phone number..", Toast.LENGTH_SHORT)
                        .show()
                } else {

                    val number = "+91${phoneNumber.value}"
                    // on below line calling method to generate verification code.
                    sendVerificationCode(number, mAuth, context as Activity, callbacks)
                }
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Generate OTP", modifier = Modifier.padding(8.dp))
        }

        // adding spacer on below line.
        Spacer(modifier = Modifier.height(10.dp))

        // on below line creating text field for otp
        TextField(
            // on below line we are specifying
            // value for our course duration text field.
            value = otp.value,
            //specifying key board on below line.
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            // on below line we are adding on
            // value change for text field.
            onValueChange = { otp.value = it },

            // on below line we are adding place holder
            // as text as "Enter your course duration"
            placeholder = { Text(text = "Enter your otp") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        // adding spacer on below line.
        Spacer(modifier = Modifier.height(10.dp))


        Button(
            onClick = {
                // on below line we are validating
                // user input parameters.
                if (TextUtils.isEmpty(otp.value.toString())) {
                    // displaying toast message on below line.
                    Toast.makeText(context, "Please enter otp..", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    // on below line generating phone credentials.
                    val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(
                        verificationID.value, otp.value
                    )
                    // on below line signing within credentials.
                    signInWithPhoneAuthCredential(
                        credential,
                        mAuth,
                        context as Activity,
                        context,
                        message,
                        navController
                    )
                }
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Verify OTP", modifier = Modifier.padding(8.dp))
        }

        // on below line adding spacer.
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            // on below line displaying message for verification status.
            text = message.value,
            style = TextStyle(color = greenColor, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
    }

    // on below line creating callback
    callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            // on below line updating message
            // and displaying toast message
            message.value = "Verification successful"
            Toast.makeText(context, "Verification successful..", Toast.LENGTH_SHORT).show()
        }

        override fun onVerificationFailed(p0: FirebaseException) {
            // on below line displaying error as toast message.
            message.value = "Fail to verify user : \n" + p0.message
            Toast.makeText(context, "Verification failed..", Toast.LENGTH_SHORT).show()
        }

        override fun onCodeSent(verificationId: String, p1: PhoneAuthProvider.ForceResendingToken) {
            // this method is called when code is send
            super.onCodeSent(verificationId, p1)
            verificationID.value = verificationId
        }
    }
}

// on below line creating method to
// sign in with phone credentuals.
private fun signInWithPhoneAuthCredential(
    credential: PhoneAuthCredential,
    auth: FirebaseAuth,
    activity: Activity,
    context: Context,
    message: MutableState<String>,
    navController: NavController
) {
    // on below line signing with credentials.
    auth.signInWithCredential(credential)
        .addOnCompleteListener(activity) { task ->
            // displaying toast message when
            // verification is successful
            if (task.isSuccessful) {
                message.value = "Verification successful"
                Toast.makeText(context, "Verification successful..", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.UserInfoScreen.route)
            } else {
                // Sign in failed, display a message
                if (task.exception is FirebaseAuthInvalidCredentialsException) {
                    // The verification code
                    // entered was invalid
                    Toast.makeText(
                        context,
                        "Verification failed.." + (task.exception as FirebaseAuthInvalidCredentialsException).message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
}

// below method is use to send
// verification code to user phone number.
private fun sendVerificationCode(
    number: String,
    auth: FirebaseAuth,
    activity: Activity,
    callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
) {
    // on below line generating options for verification code
    val options = PhoneAuthOptions.newBuilder(auth)
        .setPhoneNumber(number) // Phone number to verify
        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
        .setActivity(activity) // Activity (for callback binding)
        .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
        .build()
    PhoneAuthProvider.verifyPhoneNumber(options)
}
