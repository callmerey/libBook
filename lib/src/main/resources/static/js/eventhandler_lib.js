function movePage(type, search, page, lastpage, jump) {
    var settings = {
        url: "/lib/" + type,
        type: "GET",
        data: { "page": page + jump, "search": search },
        beforeSend: function() {
            jQuery("#mainTable").hide();
            hideButtons();
            jQuery("#loading").show();
        },
        success: function(data) {
            var new_url = "/lib/" + type + "?page=" + (page + jump)
            if (search) { new_url += "&search=" + search }
            window.history.pushState(null, "Maplelegends Library", new_url);
            jQuery("#mainTable").html(jQuery(data).find("#mainTable"));
            jQuery("#loading").hide();
            jQuery("#mainTable").show();
            refresh(page + jump, lastpage);
        }
    };
    jQuery.ajax(settings);
}

function changeTab(id, type, tab, ) {
    var settings = {
        url: "/lib/" + type,
        type: "GET",
        data: { "id": id, "tab": tab },
        beforeSend: function() {
            jQuery("#infoTable").hide();
            jQuery("#loading").show();
        },
        success: function(data) {
            jQuery("#infoTable").html(jQuery(data).find("#infoTable"));
            jQuery("#loading").hide();
            jQuery("#infoTable").show();
        }
    };
    jQuery.ajax(settings);
}

function changeActiveTab(oldTab, newTab) {
    jQuery(oldTab).removeClass("active");
    jQuery(newTab).addClass("active");
}

function hideButtons() {
    jQuery("#previous").hide();
    jQuery("#prev2").hide();
    jQuery("#prev1").hide();
    jQuery("#current").hide();
    jQuery("#next1").hide();
    jQuery("#next2").hide();
    jQuery("#next").hide();
}

function refresh(page, lastpage) {
    jQuery("#prev2").text(page - 2);
    jQuery("#prev1").text(page - 1);
    jQuery("#current").text(page);
    jQuery("#next1").text(page + 1);
    jQuery("#next2").text(page + 2);
    jQuery("#current").show();
    if (page <= 1) {
        jQuery("#prev2").hide();
        jQuery("#prev1").hide();
        jQuery("#previous").hide();
    } else if (page == 2) {
        jQuery("#prev2").hide();
        jQuery("#prev1").show();
        jQuery("#previous").show();
    } else {
        jQuery("#prev2").show();
        jQuery("#prev1").show();
        jQuery("#previous").show()
    }
    if (page == (lastpage - 1)) {
        jQuery("#next1").show();
        jQuery("#next2").hide();
        jQuery("#next").show();
    } else if (page >= lastpage) {
        jQuery("#next1").hide();
        jQuery("#next2").hide();
        jQuery("#next").hide();
    } else {
        jQuery("#next1").show();
        jQuery("#next2").show();
        jQuery("#next").show();
    }
}