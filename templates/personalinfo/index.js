/*
 * @Description: 
 * @Autor: Happy_Pedestrian
 * @Date: 2021-09-12 13:11:41
 * @LastEditors: Happy_Pedestrian
 * @LastEditTime: 2021-09-12 13:11:41
 */
window.onload = function()
{
    document.getElementById("id").onclick = ChangeColor;
}
function ChangeColor(id) {

    id.className = "nav-active";
    
  }
