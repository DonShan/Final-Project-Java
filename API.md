# REST API reference (for the iOS app)

All endpoints accept and return JSON (`Content-Type: application/json`).
Missing records return `404`, creates return `201`, deletes return `204`.

| Service          | Default port |
|------------------|--------------|
| accountService   | 2120         |
| productCategory  | 5550         |
| order            | 4140         |
| BuyingDetails    | 3130         |
| authorization-server | 9191     |

## Account (`accountService`)

| Method | Path | Body | Notes |
|--------|------|------|-------|
| POST | `/customer` | `{"customerName","email","password","customerAddress":{"addressNo","street","city"}}` | Register. `409` if the name is taken. The password is never returned. |
| POST | `/customer/login` | `{"username","password"}` | Returns `{"status","message","accessTokens":{"access_token","token_type","refresh_token","expires_in","scope"}}`. `401` on bad credentials. |
| GET | `/customer/{id}` | | Customer details. |

`POST /customer/CustomerDetails` and `GET /customer/login/{username}/{password}` are kept for the
Angular client. Use the POST login from iOS so the password is not sent in the URL.

## Products (`productCategory`)

| Method | Path | Body |
|--------|------|------|
| GET | `/product` | List all products |
| POST | `/product` | `{"productName","quentity","price"}` |
| GET | `/product/{id}` | |
| GET | `/product/name/{productName}` | |
| GET | `/product/price/{price}` | List of products at that price |
| DELETE | `/product/{id}` | |

## Orders (`order`)

| Method | Path | Body |
|--------|------|------|
| GET | `/order` | List all orders |
| POST | `/order` | `{"ordername","orderprice"}` (`/order/orderDetails` also works) |
| GET | `/order/{id}` | |
| GET | `/order/ordername/{orderName}` | |
| DELETE | `/order/{id}` | |

## Cart (`BuyingDetails`)

| Method | Path | Body |
|--------|------|------|
| GET | `/cart/details` | List all cart entries |
| POST | `/cart/details` | `{"orderNo"}` |
| GET | `/cart/details/{id}` | |
| DELETE | `/cart/details/{id}` | |
