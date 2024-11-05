package com.luis.composecontactlist

import android.os.Bundle
import android.provider.ContactsContract.Contacts
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luis.composecontactlist.ui.theme.ComposeContactListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeContactListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    val person1 = ContactPerson(
                        name = "Luisa",
                        number =  "(34) 99903-8893",
                        image = R.drawable.sample1

                    )

                    val person2 = ContactPerson(
                        name = "Arthur",
                        number =  "(34) 99903-8893",
                        image = R.drawable.sample2

                    )

                    val person3 = ContactPerson(
                        name = "Eduarda",
                        number =  "(34) 99903-8893",
                        image = R.drawable.sample3

                    )
                    val person4 = ContactPerson(
                        name = "Maria",
                        number =  "(34) 99903-8232",
                        image = R.drawable.sample4

                    )
                    val person5 = ContactPerson(
                        name = "Marcia",
                        number =  "(34) 99907-8893",
                        image = R.drawable.sample5

                    )
                    val person6 = ContactPerson(
                        name = "Eleusa",
                        number =  "(34) 99803-8893",
                        image = R.drawable.sample6

                    )
                    val person7 = ContactPerson(
                        name = "Lurdes",
                        number =  "(34) 95903-8893",
                        image = R.drawable.sample7

                    )
                    val person8 = ContactPerson(
                        name = "Maria Clara",
                        number =  "(34) 99303-8893",
                        image = R.drawable.sample8

                    )
                    val person9 = ContactPerson(
                        name = "Matheus",
                        number =  "(34) 99703-8893",
                        image = R.drawable.sample9

                    )
                    val person10 = ContactPerson(
                        name = "Carlos",
                        number =  "(34) 99903-8893",
                        image = R.drawable.sample10

                    )
                    val person11 = ContactPerson(
                        name = "Yamete Kudasai",
                        number =  "(34) 99506-8893",
                        image = R.drawable.sample11

                    )
                    val person12 = ContactPerson(
                        name = "Robson",
                        number =  "(34) 99903-8865",
                        image = R.drawable.sample12

                    )
                    val person13 = ContactPerson(
                        name = "Claudia",
                        number =  "(34) 99903-8834",
                        image = R.drawable.sample13

                    )
                    val person14 = ContactPerson(
                        name = "McBrinquedo",
                        number =  "(34) 99903-8838",
                        image = R.drawable.sample14

                    )
                    val person15 = ContactPerson(
                        name = "Laura",
                        number =  "(34) 99903-8239",
                        image = R.drawable.sample15

                    )
                    val person16 = ContactPerson(
                        name = "Joaquina",
                        number =  "(34) 99903-4293",
                        image = R.drawable.sample16

                    )


                    val contacts = listOf(person1, person2, person3, person4, person5, person6, person7, person9, person10, person11, person12, person13, person14, person15, person16)

                    Column {
                        ContactsTitle()
                        Spacer(modifier = Modifier.size(16.dp))
                        LazyColumn {
                            items(contacts) { contact ->
                                ContactsCard(
                                    ContactPerson = contact,
                                    onClick = {}
                                )

                            }
                        }
                    }


                }
            }

        }
    }
}




@Composable
fun ContactsCard(
    ContactPerson: ContactPerson,
    onClick: () -> Unit

) {
    Spacer(modifier = Modifier.size(16.dp))
    Column(
        modifier = Modifier
            .padding(6.dp)
            .clickable(onClick = onClick)
    ) {


        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(16.dp)),
                painter = painterResource(id = ContactPerson.image),
                contentScale = ContentScale.FillWidth,
                contentDescription = "Contact Image"
            )
            Column {
                Text(
                    text = ContactPerson.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    text = ContactPerson.number,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color =  Color.Gray
                )
            }
        }
    }

}

@Composable
fun ContactsTitle() {

    Row(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Contacts",
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp
        )
    }
}

data class ContactPerson(
    val name: String,
    val number: String,
    @DrawableRes val image: Int
)

