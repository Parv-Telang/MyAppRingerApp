package com.example.mytestapp.userinfo.presentation

import android.app.DatePickerDialog
import android.util.Size
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import java.util.*


@Composable
fun UserInfoUI() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        // on below line adding vertical and
        // horizontal alignment for column.
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FistNameUI()
        LastNameUI()
        DOB()
        GenderUI()
        PinCode()
        SubmitButton()

    }

}

@Composable
fun FistNameUI() {
    val firstName = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        // on below line we are specifying
        // value for our course name text field.
        value = firstName.value,
        // on below line specifying key board type as number.
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

        // on below line we are adding on
        // value change for text field.
        onValueChange = { firstName.value = it },

        // on below line we are adding place holder
        // as text as "Enter your course name"
        placeholder = { Text(text = "Enter your First Name") },

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
}

@Composable
fun LastNameUI() {
    val lastName = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        // on below line we are specifying
        // value for our course name text field.
        value = lastName.value,
        // on below line specifying key board type as number.
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

        // on below line we are adding on
        // value change for text field.
        onValueChange = { lastName.value = it },

        // on below line we are adding place holder
        // as text as "Enter your course name"
        label = { Text(text = "Enter your last name") },

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
}

@Composable
fun GenderUI() {
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val listOfGender = listOf("Male", "Female", "NA")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(androidx.compose.ui.geometry.Size.Zero) }

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {

        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = {Text("Label")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier.width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            listOfGender.forEach { label ->
                DropdownMenuItem(onClick = {
                    mSelectedText = label
                    mExpanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }
}

@Composable
fun PinCode() {
    val pincode = remember { mutableStateOf("") }
    OutlinedTextField(
        // on below line we are specifying
        // value for our course name text field.
        value = pincode.value,
        // on below line specifying key board type as number.
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

        // on below line we are adding on
        // value change for text field.
        onValueChange = { pincode.value = it },

        // on below line we are adding place holder
        // as text as "Enter your course name"
        placeholder = { Text(text = "Enter your pincode") },

        // on below line we are adding modifier to it
        // and adding padding to it and filling max width
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ,

        // on below line we are adding text style
        // specifying color and font size to it.
        textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

        // on below line we are adding
        // single line to it.
        singleLine = true,
    )
}

@Composable
fun DOB() {

    // Fetching the Local Context
    val mContext = LocalContext.current

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    // Declaring a string value to
    // store date in string format
    val mDate = remember { mutableStateOf("") }

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            // on below line we are specifying
            // value for our course name text field.
            value = mDate.value,
            // on below line specifying key board type as number.
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            // on below line we are adding on
            // value change for text field.
            onValueChange = { mDate.value = it },

            // on below line we are adding place holder
            // as text as "Enter your course name"
            placeholder = { Text(text = "Enter your DOB") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )
        // Creating a button that on
        // click displays/shows the DatePickerDialog
        Button(onClick = {
            mDatePickerDialog.show()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)),
        modifier = Modifier.height(50.dp)) {
            Text(text = "Open Date Picker", color = Color.White)
        }

        // Adding a space of 100dp height
//        Spacer(modifier = Modifier.size(100.dp))
//
//        // Displaying the mDate value in the Text
//        Text(text = "Selected Date: ${mDate.value}", fontSize = 30.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun SubmitButton() {
    Button(onClick = {}, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)),
        modifier = Modifier.height(50.dp)) {
        Text(text = "Submit", color = Color.White)
    }
}