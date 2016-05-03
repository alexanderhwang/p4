(function() {
  $(function() {
    return $.get("/storemoney", function(storemoney) {
      return $("#storemoney").append(storemoney);
    });
  });

  $(function() {
    return $.get("/storeinventory", function(storeinventory) {
      return $("#storeinventory").append(storeinventory);
    });
  });

  $(function() {
    return $.get("/selfmoney", function(selfmoney) {
      return $("#selfmoney").append(selfmoney);
    });
  });

  $(function() {
    return $.get("/selfinventory", function(selfinventory) {
      return $("#selfinventory").append(selfinventory);
    });
  });

  $(function() {
    return $.get("/message", function(message) {
      return $("#message").append(message);
    });
  });

  $(function() {
    return $.get("/pricelist", function(pricelist) {
      return $("#pricelist").append(pricelist);
    });
  });

}).call(this);

//# sourceMappingURL=index.js.map
