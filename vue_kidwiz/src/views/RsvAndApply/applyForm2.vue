        },

        updateTextLength() {
            this.textLength = this.requestText.length;
        }

    }
}
</script>

<style>
.reservation-form {
    width: 100%;
    max-width: 600px;
    margin: auto;
}

.counseling-types {
    display: flex;
    gap: 10px;
}

.counseling-type {
    padding: 10px;
    border: 1px solid #ccc;
    cursor: pointer;
}

.counseling-type.selected {
    background-color: #4CAF50;
    color: white;
}


.form-row {
    display: flex;
    flex-wrap: wrap;
    margin-right: -5px;
    margin-left: -5px;
}

.form-row>.col-md-4,
.form-row>.col-md-8 {
    padding-right: 5px;
    padding-left: 5px;
}

.form-row>.col-md-4 {
    flex: 0 0 33.333333%;
    max-width: 33.333333%;
}
