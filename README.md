# AlgoDomain-Task
 SPRINGBOOT CRUD REST API's
 
 - Developer : Amol Nandivale
 - Date : 02-02-2023
 - Email id: nandivaleamol@gmail.com

#Task- Product Repository and It's CRUD REST API's

# Used Technologies
1. java 8 - to bring functional programming and concise code
2. Spring boot- Creating CRUD Rest API's
3. Spring Data JPA
4. Swagger API Documentation
5. Database: MySQL
6. Lombok Library - to avoid boilerplate code of entity classes
7. Builder design pattern
8. Handled Basic Exceptions to avoid runtime exceptions

# Unit Testing
- All backend service methods are well tested by using unit.
- JUnit library

# API Testing Tools
- Postman
- Swagger UI

# Samples REST API's:

# POST: http://localhost:8080/api/products/

{
"productId": 1005,
"name": "US Polo Assn",
"productType": "T-Shirt",
"category": "Clothing",
"basePrice": "1200",
"discount": 40,
"charges": {
"gst": "12",
"delivery": "0"
}
}
* response:
{
"productId": 1005,
"name": "US Polo Assn",
"productType": "T-Shirt",
"category": "Clothing",
"basePrice": 1200.0,
"discount": 40.0,
"charges": {
"id": 6,
"gst": 12.0,
"delivery": 0.0
},
"finalPrice": 0.0
}

# GET: http://localhost:8080/api/products/1001
- fetch single product by id
-
* Response:
  {
  "productId": 1001,
  "name": "Lenovo Yoga Pro",
  "productType": "Laptop",
  "category": "Laptop",
  "basePrice": 50000.0,
  "discount": 7500.0,
  "charges": {
  "id": 1,
  "gst": 9000.0,
  "delivery": 350.0
  },
  "finalPrice": 51500.00035762787
  }
# GET: http://localhost:8080/api/products/
- Fetch all products
-
* Response:

  [
  {
  "productId": 1001,
  "name": "Lenovo Yoga Pro",
  "productType": "Laptop",
  "category": "Laptop",
  "basePrice": 50000.0,
  "discount": 7500.0,
  "charges": {
  "id": 1,
  "gst": 9000.0,
  "delivery": 350.0
  },
  "finalPrice": 51500.00035762787
  },
  {
  "productId": 1002,
  "name": "LG Washing Machine ",
  "productType": "Washing Machine",
  "category": "Home Appliances",
  "basePrice": 25000.0,
  "discount": 3750.0,
  "charges": {
  "id": 2,
  "gst": 4500.0,
  "delivery": 350.0
  },
  "finalPrice": 25750.000178813934
  },
  {
  "productId": 1003,
  "name": "Laptop",
  "productType": "Laptop",
  "category": "Electronics",
  "basePrice": 60000.0,
  "discount": 9000.0,
  "charges": {
  "id": 3,
  "gst": 10800.0,
  "delivery": 350.0
  },
  "finalPrice": 61800.00042915344
  },
  {
  "productId": 1004,
  "name": "Neelkamal Been Bag",
  "productType": "Sofa Set",
  "category": "Furniture",
  "basePrice": 350.0,
  "discount": 35.0,
  "charges": {
  "id": 5,
  "gst": 63.000004,
  "delivery": 300.0
  },
  "finalPrice": 378.0000025033951
  },
  {
  "productId": 1005,
  "name": "US Polo Assn",
  "productType": "T-Shirt",
  "category": "Clothing",
  "basePrice": 1200.0,
  "discount": 480.0,
  "charges": {
  "id": 6,
  "gst": 144.0,
  "delivery": 0.0
  },
  "finalPrice": 863.9999967813492
  }
  ]

# PUT: http://localhost:8080/api/products/1001
- Update product details by product id
- http://localhost:8080/api/products/1001
* Request:
  {
  "productId": 1001,
  "name": "Lenovo Yoga Pro",
  "productType": "Laptop",
  "category": "Laptop",
  "basePrice": 50000.0,
  "discount": 15.0,
  "charges": {
  "id": 1,
  "gst": 18.0,
  "delivery": 350.0
  }
  }

* Response:
  {
  "productId": 1001,
  "name": "Lenovo Yoga Pro",
  "productType": "Laptop",
  "category": "Laptop",
  "basePrice": 50000.0,
  "discount": 15.0,
  "charges": {
  "id": 1,
  "gst": 18.0,
  "delivery": 350.0
  },
  "finalPrice": 50353.0
  }

# DELETE: http://localhost:8080/api/products/1003
- To delete existing resource on server
- Response: 
- 
 {
    "message": "Product deleted successfully!!",
    "success": true
}




