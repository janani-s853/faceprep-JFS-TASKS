
function appendValue(value) {
    const result = document.getElementById('result');
    result.value += value;
  }
  

  function clearResult() {
    document.getElementById('result').value = '';
  }
  

  function backspace() {
    const result = document.getElementById('result');
    result.value = result.value.slice(0, -1);
  }
  

  function calculateResult() {
    const result = document.getElementById('result');
    try {
      result.value = eval(result.value); 
    } catch (error) {
      result.value = 'Error'; 
    }
  }
  

  document.addEventListener('keydown', function (event) {
    const key = event.key;
    const result = document.getElementById('result');
  
    if (!isNaN(key) || key === '.') {
      appendValue(key);
    } else if (['+', '-', '*', '/', '%'].includes(key)) {
      appendValue(key);
    } else if (key === 'Enter') {
      event.preventDefault();
      calculateResult();
    } else if (key === 'Backspace') {
      backspace();
    } else if (key === 'Escape') {
      clearResult();
    }
  });
  