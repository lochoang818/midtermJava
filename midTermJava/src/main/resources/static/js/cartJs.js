$(document).ready(function () {
    var total = $(".totalPriceCart")
    $(document).on("click", ".add-single", function () {

        var shoesId = $(this).data('id');
        var input = $('input[data-id="' + shoesId + '"]').val();
        console.log(input)
        window.location.href = '/Order/AddToCart/'+shoesId+'?quantity='+input;

        // fetch('/Order/AddToCart/'+shoesId+'?quantity='+input, {
        //     method: 'Get',
        //     headers: {
        //         'Accept': 'application/json',
        //         'Content-Type': 'application/json'
        //     },
        //
        // })
        //
        //
        //     .catch(error => {
        //         console.error('Error:', error);
        //     });
    });
    $(document).on("click", ".btnMinus", function () {

        var shoesId = $(this).data('id');
        var input = $('input[data-id="' + shoesId + '"]');
        var h5 = $('h5[data-id="' + shoesId + '"]');
        if(parseInt(input.val()) !==1){
            var data = {
                shoesId: shoesId
            }
            fetch('/Order/DecreaseShoes', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data) // Truyền dữ liệu trong một đối tượng JSON
            })
                .then(response => response.json())
                .then(data => {
                    input.val(data.quantity);

                    h5.text(data.price);

                    var currentPrice = parseFloat(total.text()) - (data.price / data.quantity);
                    total.text(currentPrice)
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }

    });

    $(document).on("click", ".btnPlus", function () {

        var shoesId = $(this).data('id');
        var input = $('input[data-id="' + shoesId + '"]');
        var h5 = $('h5[data-id="' + shoesId + '"]');

        var data = {
            shoesId: shoesId
        }
        fetch('/Order/IncreaseShoes', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data) // Truyền dữ liệu trong một đối tượng JSON
        })
            .then(response => response.json())
            .then(data => {
                input.val(data.quantity);

                // Đặt nội dung cho phần tử <span> sử dụng jQuery
                h5.text(data.price);
                // totalPriceArray.forEach(function (totalPriceSpan) {
                //     totalPriceSpan.innerHTML = data.totalPriceCart + "$";
                // });



                var currentPrice = parseFloat(total.text()) + (data.price / data.quantity);
                total.text(currentPrice)
            })
            .catch(error => {
                console.error('Error:', error);
            });
        // Giảm giá trị xuống 1 và gán lại cho trường input
    });




    // Thu thập dữ liệu từ các trường

    var checkoutButton = document.getElementById('checkoutButton');

    checkoutButton.addEventListener('click', function (event) {
        // Ngăn chặn hành vi mặc định của nút (tránh chuyển hướng hoặc gửi yêu cầu form)
        event.preventDefault();
        const name = document.querySelector('input[name="name"]').value;
        const address = document.querySelector('input[name="address"]').value;
        const email = document.querySelector('input[name="email"]').value;
        const phone = document.querySelector('input[name="phone"]').value;

        // Để lấy total price từ view, bạn có thể sử dụng JavaScript để lấy nó



        // Tạo đối tượng chứa dữ liệu để gửi lên máy chủ
        const data = {
            name: name,
            email: email,
            phone: phone,

            address: address,
            totalPrice: total.text()
        };
        fetch('/Order/completeCheckout', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(response => response.json())
            .then(data => {
                console.log(data)
                alert("Đặt Hàng Thành Công! Đơn hàng của bạn có ID: " + data.order_id)
            })
            .catch(error => {
                console.error('Lỗi: ', error);
            });

    });


});

