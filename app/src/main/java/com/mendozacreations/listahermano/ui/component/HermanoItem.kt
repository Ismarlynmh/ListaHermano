package com.mendozacreations.listahermano

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mendozacreations.listahermano.data.dto.HermanoDto

@Composable
    fun HermanoItem(
    hermano: HermanoDto,
    onClick: (HermanoDto) -> Unit
        ) {
   Card(
       shape = RoundedCornerShape(8.dp),
       elevation = 5.dp,
       modifier = Modifier
           .padding(horizontal = 8.dp, vertical = 8.dp)
           .fillMaxWidth()
   ){
   Column(modifier = Modifier
       .fillMaxWidth()
       .clickable { onClick(hermano) }
   ) {
       Image(
           painter = rememberAsyncImagePainter(hermano.imageUrl),
           contentDescription = null,
           modifier = Modifier.size(55.dp)
       )
       Row(
           modifier = Modifier.fillMaxWidth().height(30.dp).padding(5.dp),
       ) {
           Text(
               text = "Name: ${hermano.descripcion}",
               color = Color.Black,
               fontStyle = FontStyle.Normal,
           )

       }
       Row(
           modifier = Modifier.fillMaxWidth().height(30.dp).padding(2.dp)
       ) {
           Text(
               text = "Tel: ${hermano.telefono}",
               color = Color.Black,
               fontStyle = FontStyle.Normal,
           )
       }
       Row(
           modifier = Modifier.fillMaxWidth().height(30.dp).padding(2.dp),
       ) {

           Text(
               text = "Age: ${hermano.valor}",
               color = Color.Black,
               fontStyle = FontStyle.Normal,
           )
       }

   }
}
}
