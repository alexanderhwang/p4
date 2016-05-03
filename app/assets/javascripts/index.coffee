$ ->
  $.get "/storemoney", (storemoney) ->
     $("#storemoney").append storemoney
$ ->
  $.get "/storeinventory", (storeinventory) ->
     $("#storeinventory").append storeinventory
$ ->
  $.get "/selfmoney", (selfmoney) ->
     $("#selfmoney").append selfmoney
$ ->
  $.get "/selfinventory", (selfinventory) ->
     $("#selfinventory").append selfinventory
$ ->
  $.get "/message", (message) ->
     $("#message").append message
$ ->
  $.get "/pricelist", (pricelist) ->
     $("#pricelist").append pricelist