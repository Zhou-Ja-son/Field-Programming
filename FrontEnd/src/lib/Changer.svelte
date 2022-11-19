<script>
  const m = [
    "零",
    "壹",
    "贰",
    "叁",
    "肆",
    "伍",
    "陆",
    "柒",
    "捌",
    "玖",
    "拾",
    "佰",
    "仟",
  ];
  let number = 0;
  $: bigNumber = (() => {
    if (number < 0 || number > 999999999999) {
      alert("错误输入")
      return "错误输入";
    }
    return digitToCNchar(number)
  })();

  function digitToCNchar(money) {
    const digit = ["零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"];
    const declmalUtil = ["角", "分"];
    const IntUtilExc = ["元", "万", "亿", "兆"];
    const IntUtilBac = ["", "拾", "佰", "仟"];
    const head = money < 0 ? "负" : "";
    money = Math.abs(money);
    let res = "";
    //处理小数
    // for(let i = 0;i<declmalUtil.length;i++){
    //   let a = Math.pow(10,i+1);
    //   a= Math.floor(times(a,money))%10;
    //   res += (digit[a]+declmalUtil[i]).replace(/(零.)+/,'');
    // }
    if (res.length < 1) {
      res = "整";
    }
    //处理整数部分
    let IntPart = Math.floor(money);
    for (let i = 0; i < IntUtilExc.length && IntPart > 0; i++) {
      let part = "";
      for (let j = 0; j < IntUtilBac.length; j++) {
        let a = IntPart % 10;
        IntPart = Math.floor(IntPart / 10);
        part = digit[a] + IntUtilBac[j] + part;
      }
      res = part + IntUtilExc[i] + res;
    }
    res = res.replace(/(零[拾佰仟])*零元/, "元");
    res = res.replace(/^(零.)+/, "");
    res = res.replace(/(零[拾佰仟])+/g, "零");
    res = res.replace(/零([万亿兆])+/g, "$1");
    res = res.replace(/零([万亿兆])+/g, "");
    res = res.replace(/^整$/, "零元整");
    return head + res;
  }
</script>


<div class="  w-full h-60vh p-20">
  <div class="relative bg-opacity-50 bg-white rounded-lg p-10 backdrop-blur-md border border-white">
    <img src="src\assets\fuda.jpg" class="absolute top-10 left-10 w-20 h-20 rounded-full" alt="">
    <div class="flex flex-col items-center">
      <div class="font-bold text-4xl text-red-400">大小写转换</div>
      <textarea type="number" bind:value={number} cols="20"  class="m-4 p-4"/>
      <button class="bg-red-400 rounded-full p-2 text-white w-20 cursor-pointer">转换</button>
      <textarea type="number" bind:value={bigNumber} cols="20" class="m-4 p-4" />
    </div>
    <img src="src/assets/robot.png" alt="" class="absolute w-64 right-0 bottom-0 translate-y-3/4">
  </div>
</div>

