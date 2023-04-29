<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.zhaxybek.projectbook.db.Book" %>
<%@ page import="kz.zhaxybek.projectbook.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="head.jsp"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<%@include file="navbar.jsp"%>
<div class="bodyy">
    <div class="option">

    </div>
    <div class="Pro">
        <div class="account">
            <div class="img_photo">
                <img src="https://dovga.net/media/photo/large/757.jpg" alt="">
            </div>

        </div>

    </div>
    <div class="main">
        <div class="about_me">
            <div class="name_surname">
                <span class="namee"><% if (session.getAttribute("username") != null) { %>
     <%= session.getAttribute("username") + " "  +   "(online)"
       %>
<% } %></span>
                <button onclick="logOut()" style="background-color: #4CAF50; color: white; border-radius: 25px; padding: 10px 20px; border: none;">LogOut</button>
                <script>
                    function logOut() {
                    fetch('/logOut')
                        .then(response => {
                            if (response.ok) {
                                window.location.href = '/login.jsp';
                            }
                        })
                        .catch(error => console.error(error));
                }
                </script>
            </div>
            <hr>
            <hr>
        </div>
        <div class="picturee">
            <label style="color: black;" > <strong style="font-size: 25px">REVIEWS </strong>  </label>
            <%@include file="add-critique.jsp"%>
            <br>
            <%   ArrayList<Items> itemder = (ArrayList<Items>) request.getAttribute("itemsss");
                if(itemder!=null){
                    for(Items items : itemder){
            %>
            <div class="post">
                <div class="post-header">
                    <div class="post-info">
                      <strong>  <h1 class="post-author" style="font-size: 25px;"><%=items.getName()%></h1></strong>
                    </div>
                </div>
                <div class="post-body">
                    <p class="post-text" style="font-size: 20px;"> <%=items.getDescription()%></p>
                </div>
            </div>
            <% }} %>
        </div>
            </div>
        </div>
    </div>
</div>
</div>

<style>
    body{
        margin:0;
        background-color:#D9DDE3;
        font-family: "Times New Roman";
    }

    .find input{
        background-color: whitesmoke;
        padding: 2px;
        height: 20px;
        border: 1px lightgray solid;
        border-radius: 10px 10px 10px 10px;
        padding-left: 15px;
    }
    .post {
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
    }

    .post-header {
        display: flex;
        align-items: center;
        padding: 10px;
    }

    .post-info {
        display: flex;
        flex-direction: column;
    }

    .post-author {
        font-weight: 700;
        font-size: 18px;
        margin-top: 0;
        margin-bottom: 5px;
    }



    .post-body {
        padding: 10px;
    }

    .post-text {
        font-size: 18px;
        margin-top: 0;
        margin-bottom: 10px;
    }




    .post-actions button {
        background-color: transparent;
        border: none;
        color: #007bff;
        font-size: 16px;
        cursor: pointer;
        margin-right: 20px;
    }

    .post-actions button:hover {
        text-decoration: underline;
    }



    .post-stats div {
        margin-right: 20px;
    }


    .bodyy{

        margin: 20px 150px 0 100px ;
        display: flex;
        justify-content: space-between;
    }
    .option{
        width: 10%;
        margin-left: 100px;
        height: 250px;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        text-decoration: none;


    }
    .option a{
        text-decoration: none;
        color: black;
    }

    /* Pro */
    .Pro{
        display: flex;
        flex-direction: column;
    }
    .account{
        background-color:aliceblue;
        justify-content: center;
        padding: 10px;
        border: 1px lightgray solid;
    }
    .img_photo img{
        width: 280px;
        height: 300px;;
    }

    .edit button{
        text-decoration: none;
        background-color: white;
        height: 30px;
        width: 280px;
        color: #4c75a3;
    }



    .friend_pro img{
        width: 40px;
        height: 40px;
        border: 1px lightgray solid;
        border-radius: 50%;
    }
    .friend_pro span{
        margin:5px 0 5px 0 ;
    }
    /* MAIN */
    .main{
        width: 56%;
    }
    .about_me{
        background-color:white;
    }
    .name_surname{
        display: flex;
        justify-content: space-between;
        padding: 8px;
    }
    .namee{
        font-size: 30px;
        padding-left: 15px;
    }
    .label{
        padding-left: 23px;
    }

    .detali{
        width: 500px;
        padding-left: 15px ;
        display: flex;
    }
    .probel{
        display: flex;
        flex-direction: column;
        color: gray;
    }
    .probel1{
        color: #4c75a3;
        display: flex;
        flex-direction: column;
        margin-left: 100px;
    }

    .info{
        display: flex;
        padding: 0 23px 10px 23px;
        justify-content: space-between;
    }
    .some_info{
        display: flex;
        flex-direction: column;
        align-items: center;
        color: #4c75a3;
    }

    .picturee{
        margin-top: 15px;
        background-color:white;
        padding: 10px;
        color: black;
    }
    .quantity_picture{
        display: flex;
        justify-content: space-between;
        margin: 5px;
    }

    .content{
        background-color:aliceblue;
        margin-top: 15px;
        padding: 10px;
    }
    .title_content{
        display: flex;
        justify-content: start;
        align-items: center;
    }
    .picture_content img{
        border:lightgrey;
        border-radius: 50%;
        width: 60px;
        height: 60px;
    }
    .discrip_content{
        display: flex;
        flex-direction: column;
        padding-left: 15px ;
        align-items: start;
    }

</style>
</body>
</html>