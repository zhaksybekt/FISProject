
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/add-book" method="post">
  <div class="row">
    <div class="col-12">
      <label>NAME : </label>
    </div>
  </div>
  <div class="row mt-2">
    <div class="col-12">
      <input type="text" class="form-control" name="book_name">
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <label>AUTHOR : </label>
    </div>
  </div>
  <div class="row mt-2">
    <div class="col-12">
      <input type="text" class="form-control" name="book_author">
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <label>GENRE : </label>
    </div>
  </div>
  <div class="row mt-2">
    <div class="col-12">
      <select class="form-select" name="book_genre">
        <option>Fantasy</option>
        <option>Roman</option>
        <option>Biography</option>
        <option>Horror</option>
        <option>Comics</option>
        <option>Thriller</option>
        <option>Detective</option>
      </select>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <label>PRICE : </label>
    </div>
  </div>
  <div class="row mt-2">
    <div class="col-12">
      <select class="form-select" name="book_price">
        <%
          for(int i = 0; i < 10000000; i+=1000){
        %>
        <option><%=i%></option>
        <%
          }
        %>
      </select>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <label>DESCRIPTION : </label>
    </div>
  </div>
  <div class="row mt-2">
    <div class="col-12">
      <textarea name="book_description" class="form-control" rows="5"></textarea>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <button class="btn btn-success">ADD BOOK</button>
    </div>
  </div>
</form>