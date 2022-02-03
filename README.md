
# Yummy

A simple app to hit the NY Times Most Popular Articles API and show a list of articles,
that shows details when items on the list are tapped


## API Reference

#### Get all items

```http
  GET /mostviewed/{section}/{period}.json
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |



## Features

- Most Popular Articles List
- Articles detail
- 7 days period
- all-sections


## Documentation

This app is containing a list of Most Popular NYtimes articles shown in a Recycler View. On tapping any RecyclerView item, the articles details screen pops up showing the details of the article. The list comes from the provided NY Times API using Retrofit and GSON converter using KOTLIN.

For layouts, Constraint Layout is used along with Relative and LinearLayout too.

To ensure best approaches are used in the app, I used Navigation Component and Data Binding which provides better performance and less code.

When the app starts, our NavHostFragment shows the Start destination in which the retrofit call is made to the Most Popular Articles API and populate the recycler view with very decent item layouts. All list data is bind through Adapter class using Data Binding.
To view details of an Article, Recycler view item is tapped through which out NavHostFragment navigates towards to Detail fragment bringing along the selected article ID as an argument through SafeArgs. Here the details are shown.  
## Libraries Used

- Glide
- RecycleClick
- Retrofit
- Data Binding and Navgation Compose
- SafeArgs


## Deployment

This project can be used by downloading it and opening in Android Studio. From where it can be run on real time devices.

