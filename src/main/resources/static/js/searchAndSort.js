$(document).ready(function () {
    $('#sortOptions').on('change', function () {
        var currentUrl = window.location.href;
        var sortbyValue = $(this).val();

        if (currentUrl.indexOf('sortBy=') !== -1) {
            // Nếu đã có tham số sortby, thay thế giá trị cũ bằng giá trị mới
            var regex = /([?&])sortBy=([^&]*)(&|$)/;
            currentUrl = currentUrl.replace(regex, '$1sortBy=' + sortbyValue + '$3');
        } else {
            // Nếu chưa có tham số sortby, thêm ?sortby=<giá trị mới>
            currentUrl += (currentUrl.indexOf('?') !== -1 ? '&' : '?') + 'sortBy=' + sortbyValue;
        }

        // Chuyển hướng người dùng đến URL mới
        window.location.href = currentUrl;
    });
    $('input[name="color"]').change(function () {
        // Xử lý sự kiện khi radio thay đổi giá trị
        var selectedValue = $('input[name="color"]:checked').val();
        var currentUrl = window.location.href;

        if (currentUrl.indexOf('rangePrice=') !== -1) {
            // Nếu đã có tham số sortby, thay thế giá trị cũ bằng giá trị mới
            var regex = /([?&])rangePrice=([^&]*)(&|$)/;
            currentUrl = currentUrl.replace(regex, '$1rangePrice=' + selectedValue + '$3');
        } else {
            // Nếu chưa có tham số sortby, thêm ?sortby=<giá trị mới>
            currentUrl += (currentUrl.indexOf('?') !== -1 ? '&' : '?') + 'rangePrice=' + selectedValue;
        }

        // Chuyển hướng người dùng đến URL mới
        window.location.href = currentUrl;    });
});