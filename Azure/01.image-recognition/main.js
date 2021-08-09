$(document).ready(function(){
    //do something
    $("#thisButton").click(function(){
        processImage();
    });

    $("#inputImageFile").change(function(e){
        processImageFile(e.target.files[0]);
    });

});

function processImage() {
    
    //確認區域與所選擇的相同，因為使用免費的，所以區域選West Center US
    var uriBase = "https://southcentralus.api.cognitive.microsoft.com/vision/v2.1/analyze";
    
    var params = {
        "visualFeatures": "Adult,Brands,Categories,Description,Faces,ImageType,Objects,Color,Tags",
        "details": "Celebrities,Landmarks",
        "language": "en",
    };
    //顯示分析的圖片
    var sourceImageUrl = document.getElementById("inputImage").value;
    document.querySelector("#sourceImage").src = sourceImageUrl;
    //送出分析
    $.ajax({
        url: uriBase + "?" + $.param(params),
        // Request header
        beforeSend: function(xhrObj){
            xhrObj.setRequestHeader("Content-Type","application/json");
            xhrObj.setRequestHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
        },
        type: "POST",
        // Request body
        data: '{"url": ' + '"' + sourceImageUrl + '"}',
    })
    .done(function(data) {
        //顯示JSON內容
        $("#responseTextArea").val(JSON.stringify(data, null, 2));
        $("#picDescription").text(data.description.captions[0].text);
    })
    .fail(function(jqXHR, textStatus, errorThrown) {
        //丟出錯誤訊息
        var errorString = (errorThrown === "") ? "Error. " : errorThrown + " (" + jqXHR.status + "): ";
        errorString += (jqXHR.responseText === "") ? "" : jQuery.parseJSON(jqXHR.responseText).message;
        alert(errorString);
    });
};


function processImageFile(imageObject) {
    
    //確認區域與所選擇的相同，因為使用免費的，所以區域選West Center US
    var uriBase = "https://southcentralus.api.cognitive.microsoft.com/vision/v2.1/analyze";
    
    var params = {
        "visualFeatures": "Adult,Brands,Categories,Description,Faces,ImageType,Objects,Color,Tags",
        "details": "Celebrities,Landmarks",
        "language": "en",
    };
    //顯示分析的圖片
    var sourceImageUrl = URL.createObjectURL(imageObject);
    document.querySelector("#sourceImage").src = sourceImageUrl;
    //送出分析
    $.ajax({
        url: uriBase + "?" + $.param(params),
        // Request header
        beforeSend: function(xhrObj){
            xhrObj.setRequestHeader("Content-Type","application/octet-stream");
            xhrObj.setRequestHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
        },
        type: "POST",
        processData:false,
        contentType:false,
        // Request body
        data: imageObject
    })
    .done(function(data) {
        //顯示JSON內容
        $("#responseTextArea").val(JSON.stringify(data, null, 2));
        $("#picDescription").text(data.description.captions[0].text);
    })
    .fail(function(jqXHR, textStatus, errorThrown) {
        //丟出錯誤訊息
        var errorString = (errorThrown === "") ? "Error. " : errorThrown + " (" + jqXHR.status + "): ";
        errorString += (jqXHR.responseText === "") ? "" : jQuery.parseJSON(jqXHR.responseText).message;
        alert(errorString);
    });
};